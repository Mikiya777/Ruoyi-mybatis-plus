<template>
  <div>

    {{questionList[0].radio}}
<!--    如果需要把单选改成多选，只需把type中的radio改成checkbox-->
    <div>
      <h1>{{ question }}</h1>
      <ul>
        <li v-for="(option, index) in options" :key="index">
          <label>
            <input
              type="radio"
              :value="index"
              v-model="selectedOptionIndex"
            />
            {{ option }}
          </label>
        </li>
      </ul>
      <button @click="submitAnswer">提交答案</button>
      <div v-if="showResult">
        <p>你选择了：{{ options[selectedOptionIndex] }}</p>
        <p v-if="isCorrect">恭喜，你回答正确！</p>
        <p v-else>很遗憾，你回答错误。</p>
      </div>

    </div><br/>
    /

    {{questionList[1].check}}
    <div>
      <h1>{{ question }}</h1>
      <ul>
        <li v-for="(option, index) in options" :key="index">
          <label>
            <input
              type="checkbox"
              :value="index"
              v-model="selectedOptions"
            />
            {{ option }}
          </label>
        </li>
      </ul>
      <button @click="submitAnswers">提交答案</button>
      <div v-if="showResult">
        <p>你选择了：{{ selectedOptions.map(index => options[index]).join(', ') }}</p>
        <p v-if="areAnyCorrect">恭喜，你有部分答案正确！</p>
        <p v-else>你的答案都不正确。</p>
      </div>

    </div><br/><br/>
    {{questionList[2].input}}
    <div>

    </div><br/>

  </div>
</template>

<script>
import axios from "axios";
import MyRequest, {test} from "@/api/system/user"

export default {
  name:'MyTest',
  data() {
    return {
      question: "下面哪个城市是法国的首都？",
      options: ["伦敦", "巴黎", "柏林", "罗马"],
      options2: ["伦敦", "巴黎", "柏林", "罗马"],
      selectedOptionIndex: null,
      correctOptionIndex: 1,
      showResult: false,
      yourTestId: 100,
      answers:{
        exp_id:1,
        user_id:103
      },

      selectedOptions: [],
      correctOptionIndices: [1],

      questionList:[
        {radio: '单选题'},
        {check: '多选题'},
        {input: '填空题'},
      ]
    };
  },
  computed: {
    isCorrect() {
      return this.selectedOptionIndex === this.correctOptionIndex;
    },
    areAnyCorrect() {
      return this.selectedOptions.some(index => this.correctOptionIndices.includes(index));
    },

  },
  methods: {
    async submitAnswer() {
      // 确保用户已选择答案
      if (this.selectedOptionIndex !== null) {
        //使用answerData包装要提交的数据
        const answerData = {
          questionId:1,
          expId:2,
          userId:103,

          test:"12314123",

          blank:"10,89,23",

          picture:'imgUrl'+this.pictureUrl,

        };

        const jsonData = JSON.stringify(answerData)

        try {
          //此处填写后端的URL
          // const response = await axios.post('yourURL', jsonData);
          const response = await test(jsonData);
          if (response.data.success) {
            // 提交成功处理逻辑
            console.log('答案已成功提交到后端');
          } else {
            // 提交失败处理逻辑
            console.error('答案提交失败');
          }
        } catch (error) {
          console.error('发生错误：', error);
        }
      } else {
        console.warn('请先选择一个答案');
      }
    },

    /*
    * 异步请求提交过程：
    *
    * */
    async submitAnswers() {
      if (this.selectedOptions.length > 0) {
        const selectedAnswers = this.selectedOptions.map(index => this.options[index]);

        const answerData = {
          question: this.question,
          selectedOptions: selectedAnswers,
        };

        try {
          //此处填写后端的URL
          const response = await axios.post('yourURL', answerData);
          if (response.data.success) {
            console.log('答案已成功提交到后端');
          } else {
            console.error('答案提交失败');
          }
        } catch (error) {
          console.error('发生错误：', error);
        }
      } else {
        console.warn('请至少选择一个答案');
      }
      this.showResult = true;
    },
  },
};
</script>

<style>
/* 添加样式以美化界面 */
ul {
  list-style-type: none;
  padding: 0;
}
li {
  margin-bottom: 10px;
}
</style>
