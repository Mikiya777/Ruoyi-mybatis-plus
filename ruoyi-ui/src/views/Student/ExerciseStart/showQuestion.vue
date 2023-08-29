<template>
  <div class="content-box">
    <!-- 单填空 -->
    <div v-if="type === 1">
      <template v-for="(item, index) in wrapList">
        <span :key="index" class="fill-box">
          <!-- 以index为对象的键 -->
          <div v-if="index === 0" class="div-indent"></div>
          <input
            v-if="item.input"
            type="text"
            placeholder="请输入"
            v-model="answer[index]"
            class="fill-intput"
          />
          <span v-if="item.text">{{ item.text }}</span>
        </span>
      </template>
    </div>
    <!--多填空-->
    <div v-if="type === 5">
      <template v-for="(item, index) in wrapList2">
        <span :key="index" class="fill-box">
          <!-- 以index为对象的键 -->
          <div v-if="index === 0" class="div-indent"></div>
          <input
            v-if="item.input"
            type="text"
            placeholder="请输入"
            v-model="answer[index]"
            class="fill-intput"
          />
          <span v-if="item.text">{{ item.text }}</span>
        </span>
      </template>
    </div>
    <!-- 单选题 -->
    <div v-if="type === 2">
      <div>{{ question }}</div>
      <div class="chooseOne">
        <template v-for="(item, index) in option">
          <div :key="index">
            <el-radio
              v-model="answer"
              :label="optionTransfer[index]"
              border
              class="chooseOneOption"
              size="medium"
              >{{ item }}
            </el-radio>
          </div>
        </template>
      </div>
    </div>
    <!-- 多选题 -->
    <div class="" v-if="type === 3">
      <div>{{ question }}</div>
      <div class="chooseOne">
        <el-checkbox-group v-model="answer">
          <template v-for="(item, index) in option">
            <div :key="index">
              <el-checkbox
                :label="optionTransfer[index]"
                border
                class="chooseOneOption"
                size="medium"
                >{{ item }}
              </el-checkbox>
            </div>
          </template>
        </el-checkbox-group>
      </div>
    </div>
    <div class="" v-if="type === 4">
      <div>{{ question }}</div>
      <div class="chooseOne">
        <el-input
          type="textarea"
          class="input4content"
          :autosize="{ minRows: 4, maxRows: 4 }"
          placeholder="请输入内容"
          v-model="answer"
        >
        </el-input>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "showQuestion",
  props: {
    type: {},
    option: {},
    question: {},
  },
  data() {
    return {
      answer: {},
      optionTransfer: ["A", "B", "C", "D", "E", "F"],
    };
  },
  created() {
    // 防止刷新页面的时候  type为3 的 answer不是[]类型
    this.resetAnswer();
  },

  // 防止type改变是 answer设置不成功
  watch: {
    type: {
      handler() {
        this.resetAnswer();
      },
    },
  },

  computed: {
    // 将填空题识别成input框 如果不是填空题直接返回
    wrapList() {
      if (this.type !== 1) return;
      const parsedArray = this.parseText(this.question);
      return parsedArray;
    },
    wrapList2() {
      if (this.type !== 5) return;
      const parsedArray = this.parseText(this.question);
      return parsedArray;
    },
  },

  methods: {
    parseText(input) {
      const regex = /(\[文本框\]|[^[\]]+)(?=\[文本框\]|$)/g;
      const matches = input.match(regex);

      if (!matches) {
        return [];
      }

      const result = [];
      let isInput = false;

      for (const match of matches) {
        if (match === "[文本框]") {
          result.push({ text: false, input: true });
          isInput = false;
        } else {
          if (match !== "") {
            result.push({ text: match, input: isInput });
          }
          isInput = true;
        }
      }

      return result;
    },
    resetAnswer() {
      // 多选题
      if (this.type === 3) {
        console.log("执行");
        this.answer = [];
      }
      // 单选题 和 简单题
      if (this.type === 4 || this.type === 2) {
        this.answer = "";
      }
      if (this.type === 1) {
        console.log("12312312312312312",);
        this.answer = {};
      }
      if (this.type === 5) {
        console.log("多个填空题",);
        this.answer = {};
      }
    },
  },
};
</script>

<style scoped>
.div-indent {
  width: 40px;
  height: 30px;
  display: inline-block;
}
.fill-box {
  vertical-align: middle;
  word-break: break-all;
  line-height: 35px;
}
.fill-intput {
  height: 30px;
  line-height: 35px;
  margin: 0 10px;
  font-size: 24px;
  width: 150px;
}
.chooseOne {
  margin-top: 20px;
}
.chooseOneOption {
  margin-top: 20px;
  background-color: #fafafa;
}
.input4content {
  font-size: 24px;
}
</style>
