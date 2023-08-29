<template>
  <div class="box-div">
    <img
      src="@/assets/start.png"
      alt="img"
      @click="changePage"
    />
  </div>
</template>

<script>
import { startExercise } from "@/api/student/api.js";
export default {
  name: "ExerciseStart",
  data() {
    return {};
  },

  // 保护机制
  methods: {
    changePage: function () {
      startExercise().then((res) => {
        const expId = res.data.expId;
        localStorage.setItem("exp_id", expId || "");
        // 利用浏览器localStorage 存储进行实验必要的数据, 当你一个实验还没结束时又开新的实验时，就需要把先前的next_id清除
        localStorage.removeItem("next_id");
        console.log(expId);
        // 在当前标签页中使用 window.open 打开新标签页，后面是startDetail的路由
        const newTab = window.open("/startExercise");
        // 监听新标签页的加载完成事件
        newTab.onload = () => {
          // 在新标签页中设置 sessionStorage 数据
          newTab.sessionStorage.setItem("startKey", "start");
        };
      });
    },

    /*
    transQuery:function (){
      const myid=this.id
      this.$router.push({
        path: "/one",
        query: {
          id:myid
        }

        //axios请求
      });
    }
    */
  },
};
</script>

<style scoped>
.box-div {
  height: calc(100vh - 84px);
  width: 100%;
  background-color: red;
}

img {
  height: 100%;
  width: 100%;
  object-fit: fill;
}
</style>
