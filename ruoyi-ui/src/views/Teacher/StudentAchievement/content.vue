<template>
  <div>
    <ul v-for="indexA in time" :key="indexA" class="ul-box">
      <div
        class="content-box"
        :style="indexA % 2 === 0 ? { flexDirection: 'row-reverse' } : {}"
      >
        <template v-for="(item, index) in splitData[indexA - 1]">
          <show-box
            :key="index"
            :isShow="
              indexA % 2 === 0
                ? index !== 0
                : index + 1 !== splitData[indexA - 1].length
            "
            :name="item.name"
            :question="item.question"
            :option="item.option"
            :type="item.type"
            :answer="item.answer"
            :img="item.img"
          >
          </show-box>
        </template>
      </div>
      <div
        class="border-box"
        v-if="indexA !== time"
        :style="indexA % 2 !== 0 ? { width: '85%' } : { width: '10%' }"
      ></div>
    </ul>
  </div>
</template>

<script>
import fontJson from "@/assets/list.json";
import ShowBox from "@/views/Student/ExerciseAchievement/showBox.vue";
import { getExpDedetail_expidtail } from "@/api/student/api.js";
import {getDegital} from "@/api/teacher/api";
export default {
  name: "contentCompontent",
  components: { ShowBox },

  data() {
    return {
      dataList: [],
      splitData: {},
      time: 0,
      show: false,
    };
  },
  computed: {},
  created() {
    // 拿到detail_expid
    const userId = localStorage.getItem("detail_userid");
    const expId = localStorage.getItem("detail_expid");
    this.getData(userId,expId);
    /* 配置的字段 */
    // 前端保存图片内容 根据id进行对应
    /* 后端获取字段 */
    // id 题目编号 字符串 有1-2类型
    // name 按钮名称
    // answer: 填空题存的是字符串数组json形式"["你好","你是谁"]"  选择题A选项  多选题"["A","B","C"]" 简答题直接是字符串
    // 如果没有就是返回空字符串
  },
  methods: {
    async getData(userId,expId) {
      this.show = false;
      try {
        const data = await getDegital(userId,expId);
        // 拿到数据
        let serverData = data.data;
        // 合并数据
        this.dataList = this.mergedData(serverData);
        // 分割数据
        this.time = Math.ceil(this.dataList.length / 4);

        for (let i = 0; i < this.dataList.length; i += 4) {
          const group = this.dataList.slice(i, i + 4);
          this.splitData[i / 4] = group;
        }
        this.show = true;
      } catch (E) {
        console.log(E);
      }
    },
    // 合并数据
    mergedData(serverData) {
      // 创建一个映射，将 frontendData 转换成以 id 为键的对象
      const frontendDataMap = fontJson.reduce((map, item) => {
        map[item.id] = item;
        return map;
      }, {});

      // 后端数据合并到前端
      const mergedAndFilteredData = serverData.map((serverItem) => {
        const frontendItem = frontendDataMap[serverItem.id];
        return { ...frontendItem, ...serverItem,type:frontendItem.type};
      });
      return mergedAndFilteredData;
    },
  },
};
</script>

<style scoped>
.ul-box {
  width: 95%;
  padding: 0;
  margin: 0;
  margin-left: 5%;
}

.border-box {
  height: 60px;
  border-right: 1px solid #1b9fe8;
  width: 85%;
}

.content-box {
  width: 100%;
  display: flex;
  flex-wrap: wrap;
}
</style>
