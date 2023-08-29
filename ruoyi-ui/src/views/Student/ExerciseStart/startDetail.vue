<template>
  <div class="border-box" v-show="show">
    <img
      class="imgBox"
      draggable="false"
      :src="questionObj.img"
      v-show="questionObj.img"
    />

    <show-question
      class="contentBox"
      ref="questionRef"
      :type="questionObj.type"
      :option="questionObj.option"
      :question="questionObj.question"
    ></show-question>

    <!-- 音频文件控制 -->
    <audio controls v-show="questionObj.audio" class="audio-box" ref="audioRef">
      <source :src="questionObj.audio" type="audio/mpeg" />
    </audio>

    <img class="next-box" @click="handleNext" src="/ImgItem/next_step.png" />
  </div>
</template>

<script>
import questionJSON from "@/assets/list.json";
import showQuestion from "./showQuestion.vue";
import { pushAnswer } from "@/api/student/api.js";
export default {
  components: {
    showQuestion,
  },
  name: "startComponent",
  data() {
    return {
      // 数据
      questionObj: {},
      expId: "",
      show: false,
    };
  },
  created() {
    const startKey = sessionStorage.getItem("startKey");
    if (!startKey) {
      this.$message.error("请在系统中重新进入演练页面");
      return;
    }
    // 页面放行
    this.show = true;

    // expid
    // this.expId = this.$route.query.expId;
    this.expId = localStorage.getItem("exp_id");
    const nextId = localStorage.getItem("next_id");
    console.log("this.expid", this.expId);
    // 根据实际的情况进行设置
    if (nextId) {
      this.initQuestionId(nextId);
      return;
    }
    // 设置为第一个题目，第一个题目的id就在这里设置的
    else {
      this.initQuestionId("0");
    }
  },
  methods: {
    initUserAndExp() {},

    initQuestionId(question_id) {
      // 查找到当前的questionid对象
      this.questionObj = questionJSON.find((item) => item.id === question_id);
    },

    async handleNext() {
      // 停止音频
      this.pauseAudio();
      const ref = this.$refs.questionRef;
      let answer = ref.answer;
      console.log("点击下一步获取到的答案", answer);

      if (!this.verify(answer)) return;

      // 从data中拿到数据  如果有数据  提交给服务器
      try {
        // 进行提交 服务器会返回next_id 拿到新的next_id再进行操作
        if (this.expId) {
          // 拼接参数
          const data = {
            id: this.questionObj.id,
            answer: JSON.stringify(answer),
            expId: this.expId,
            nextId: this.questionObj.next_id,
            type: this.questionObj.type,
            end : this.questionObj.end,
          };
          // 请求
          const res = await pushAnswer(data);
          console.log("res", res);
          // 拿到nextId
          const res_next_id = res.data.nextId;
          // 保证音频停止
          this.$nextTick(() => {
            // 存储下一个题目的next_id防止用户刷新界面 题目回到回溯位置
            localStorage.setItem("next_id", res_next_id);
            // 初始化下一个题目
            this.initQuestionId(res_next_id);
            // 将答案的类型重置
            ref.resetAnswer();
            // 重新加载音频
            this.loadAudio();
          });
        }
      } catch (e) {
        console.log("e", e);
      }
    },
    verify(answer) {
      // 填空题验证逻辑
      if (this.questionObj.type === 1) {
        if (Object.keys(answer).length === this.questionObj.num) {
          return true;
        } else {
          this.$message.error("请填写完整");
          return false;
        }
      }

      // 多个填空题验证逻辑
      if (this.questionObj.type === 5) {
        if (Object.keys(answer).length === this.questionObj.num) {
          return true;
        } else {
          this.$message.error("请填写完整");
          return false;
        }
      }

      if (this.questionObj.type === 2) {
        if ( answer.length>0) {
          return true;
        } else {
          this.$message.error("请填写完整");
          return false;
        }
      }

      // 多选题逻辑
      if (this.questionObj.type === 3) {
        if (answer.length !== 0) {
          return true;
        } else {
          this.$message.error("请填写完整");
          return false;
        }
      }

      // 简答题逻辑
      if (this.questionObj.type === 4) {
        if (answer.length !== 0) {
          return true;
        } else {
          this.$message.error("请填写完整");
          return false;
        }
      }
      return true;
    },

    pauseAudio() {
      const audio = this.$refs.audioRef;
      audio.pause();
    },

    loadAudio() {
      const audio = this.$refs.audioRef;
      audio.load();
    },
  },
};
</script>

<style scoped >
.border-box {
  width: 100vw;
  height: 100vh;
  padding: 0;
  position: relative;
  margin: 0;
  overflow: hidden;
}
.imgBox {
  height: 100%;
  width: 100%;
  object-fit: fill;
  user-select: none;
  pointer-events: none;
}

.contentBox {
  position: absolute;
  width: 55%;
  top: 15%;
  left: 8%;
  font-size: 24px;
}
.next-box {
  position: absolute;
  bottom: 40px;
  right: 100px;
  width: 150px;
  height: auto;
  cursor: pointer;
}

.audio-box {
  position: absolute;
  left: 40px;
  bottom: 40px;
}
</style>
