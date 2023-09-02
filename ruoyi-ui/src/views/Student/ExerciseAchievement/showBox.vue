<template>
  <li class="li-box">
    <el-popover ref="popover" placement="bottom" trigger="click">
      <el-button class="button-box" slot="reference"> {{ name }}</el-button>
      <div class="content-box">
        <!-- 展示图片 -->
        <div v-if="type===0">
          <img :src="img" class="img-box" />
        </div>

        <!-- 填空 -->
        <div
          class="fill"
          v-if="type === 1"
          v-html="`${wrapContent(question)}`"
        ></div>

        <div
          class="fill"
          v-if="type === 5"
          v-html="`${wrapContentMulti(question)}`"
        ></div>

        <div v-if="type === 2">
          <div>{{ question }}</div>
          <div class="answer-box">
            <div
              v-for="(item, index) in option"
              :key="index"
              class="answer-content"
              :style="transAnswer == index ? { backgroundColor: '#fff' } : {}"
            >
              <span :style="transAnswer == index ? { color: '#40a9ff' } : {}">
                {{ item }}</span
              >
            </div>
          </div>
        </div>
        <div class="" v-if="type === 3">
          <div>{{ question }}</div>
          <div class="answer-box">
            <div
              v-for="(item, index) in option"
              :key="index"
              class="answer-content"
              :style="
                transAnswer.includes(index) ? { backgroundColor: '#fff' } : {}
              "
            >
              <span
                :style="transAnswer.includes(index) ? { color: '#40a9ff' } : {}"
              >
                {{ item }}</span
              >
            </div>
          </div>
        </div>
        <div class="" v-if="type === 4">
          <div>{{ question }}</div>
          <div class="answer-box answer-color">
            {{ answer }}
          </div>
        </div>
      </div>
      <!-- <div v-html="content" class="content-box"></div> -->
    </el-popover>
    <div v-if="isShow" class="box-span"></div>
  </li>
</template>

<script>
export default {
  name: "showBox",
  props: {
    isShow: {
      type: Boolean,
      default: true,
    },
    type: {},
    option: {},
    name: {},
    question: {},
    answer: {},
    img: {},
  },
  data() {
    return {};
  },
  computed: {
    transAnswer() {
      try {
        //解析json
        const answer = this.answer && JSON.parse(this.answer);
        console.log("answer",answer);
        return this.mapCharacters(answer);
      } catch (error) {
        // 如果报错说明不用解析
        return this.mapCharacters(this.answer);
      }
    },
  },
  methods: {
    wrapContent(content) {
      const dataArray = (this.answer && JSON.parse(this.answer)) || [];
      console.log('dataArray'+dataArray);

      let index = 0;//单填空中不需要
      const replacedText = content.replace(
        /\[文本框\]/g,
        () => `<span class="deep-span"> ${dataArray || ""}</span>`
      );
      return replacedText;
    },

    wrapContentMulti(content) {
      console.log('MultiData+' , this.answer);
      const dataArrayM = (this.answer && JSON.parse(this.answer)) || [];


      let index = 0;//
      const replacedTextM = content.replace(
        /\[文本框\]/g,
        () => `<span class="deep-span"> ${dataArrayM[++index] || ""}</span>`
      );
      return replacedTextM;
    },


    mapCharacters(input) {
      const mapping = {
        A: 0,
        B: 1,
        C: 2,
        D: 3,
        E: 4,
        F: 5,
        G: 6,
      };

      if (typeof input === "string") {
        // 如果输入是字符串
        const result = [];
        for (let i = 0; i < input.length; i++) {
          const char = input[i];
          if (mapping[char] !== undefined) {
            result.push(mapping[char]);
          }
        }
        return result;
      } else if (Array.isArray(input)) {
        // 如果输入是数组
        return input.map((char) => mapping[char]);
      } else {
        return [];
      }
    },
  },
};
</script>

<style scoped>
.li-box {
  position: relative;
  width: 25%;
  list-style: none;
  padding: 0;
}

.img-box {
  width: 100%;
}
.content-box {
  width: 500px;
}

.button-box {
  width: 80%;
  border-radius: 100px;
  height: 40px;
}

.answer-content {
  padding: 5px 10px 5px;
  font-weight: bolder;
}
.answer-content:not(:nth-child(1)) {
  margin-top: 10px;
}

.answer-box {
  padding: 10px 8px;
  margin-top: 10px;
  background-color: #f8f8f8;
}

.answer-color {
  color: #1b9fe8;
  font-weight: bolder;
}

.box-span {
  height: 1px;
  border-top: 1px solid #1b9fe8;
  width: 20%;
  position: absolute;
  right: 0;
  transform: translateY(-50%);
  top: 50%;
}
</style>
<style>
.deep-span {
  color: #40a9ff;
  display: inline-block;
  font-weight: bolder;
  border-bottom: 1px solid #40a9ff;
  padding: 0 15px;
}
</style>
