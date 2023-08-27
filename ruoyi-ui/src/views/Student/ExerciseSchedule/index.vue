<template>
  <div>
    <h4 class="form-header">学生演练列表</h4>
    <div class="all-border-box">
      <template v-for="(item, index) in dataList">
        <div class="box-margin" :key="index + item.id">
          <div class="border-box bac">
            <h4 class="title">企业并购{{ item.expId }}次演练</h4>
            <div class="content">
              <div>演练得分：{{ item.score }}</div>
              <div>开始时间：{{ formatDateTime(item.startTime) }}</div>
            </div>
            <div class="bottom" @click="handleGoPage(item.expId, item.nextId)">
              <svg
                viewBox="64 64 896 896"
                fill="currentColor"
                width="1em"
                height="1em"
                data-icon="copy"
                aria-hidden="true"
              >
                <path
                  d="M832 64H296c-4.4 0-8 3.6-8 8v56c0 4.4 3.6 8 8 8h496v688c0 4.4 3.6 8 8 8h56c4.4 0 8-3.6 8-8V96c0-17.7-14.3-32-32-32zM704 192H192c-17.7 0-32 14.3-32 32v530.7c0 8.5 3.4 16.6 9.4 22.6l173.3 173.3c2.2 2.2 4.7 4 7.4 5.5v1.9h4.2c3.5 1.3 7.2 2 11 2H704c17.7 0 32-14.3 32-32V224c0-17.7-14.3-32-32-32zM350 856.2L263.9 770H350v86.2zM664 888H414V746c0-22.1-17.9-40-40-40H232V264h432v624z"
                ></path>
              </svg>

              继续演练
            </div>
          </div>
        </div>
      </template>
    </div>
    <div class="pagination">
      <el-pagination
        background
        @current-change="handlePageChage"
        @prev-click="handlePageChage"
        @next-click="handlePageChage"
        layout="prev, pager, next"
        v-show="pages > 0"
        :page-size="8"
        :page-count="pages"
      >
      </el-pagination>
    </div>
  </div>
</template>


<script>
import { getSchedule } from "@/api/student/api.js";
export default {
  name: "ExerciseSchedule",
  data() {
    return {
      title: "进度",
      pages: 0,
      dataList: [],
      currentPage: 1,
    };
  },
  created() {
    this.initValue();
  },
  methods: {
    initValue() {
      getSchedule({ pageNum: this.currentPage })
        .then((res) => {
          this.pages = res.data.pages;
          this.dataList = res.data.scheduleList;
          console.log(res);
        })
        .catch((e) => {
          console.log("e", e);
        });
    },
    handleGoPage(expid, nextid) {
      localStorage.setItem("exp_id", expid);
      localStorage.setItem("next_id", nextid);
      const newTab = window.open("/startExercise");
      // 监听新标签页的加载完成事件
      newTab.onload = () => {
        // 在新标签页中设置 sessionStorage 数据
        newTab.sessionStorage.setItem("startKey", "start");
      };
    },
    handlePageChage(e) {
      this.currentPage = e;
      this.initValue();
    },
    formatDateTime(a) {
      const date = new Date(a);
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, "0");
      const day = String(date.getDate()).padStart(2, "0");
      const hours = String(date.getHours()).padStart(2, "0");
      const minutes = String(date.getMinutes()).padStart(2, "0");

      return `${year}-${month}-${day} ${hours}:${minutes}`;
    },
  },
};
</script>

<style scoped>
.form-header {
  text-align: center;
  width: 100%;
  padding: 0;
  margin: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 23px;
  height: 50px;
  font-weight: bolder;
  color: rgb(0 0 0 / 65%);
}
.title {
  text-align: left;
  margin-left: 30px;
  color: rgb(0 0 0 / 65%);
  font-weight: bolder;
}

.content {
  margin-left: 20px;
  height: 50px;
  display: flex;
  flex-wrap: wrap;
  align-content: space-between;
}

.bac {
  background: url("/bac1.png");
  background-size: cover;
}
.box-margin {
  width: 25%;
  position: relative;
  display: flex;
  justify-content: center;
  margin-top: 15px;
}
.all-border-box {
  display: flex;
  flex-wrap: wrap;
  justify-content: left;
}
.bottom {
  position: absolute;
  bottom: 30px;
  left: 45px;
  color: #2f9eff;
  cursor: pointer;
}
.border-box {
  height: 180px;
  width: 280px;
}

.pagination {
  height: 100px;
  display: flex;
  justify-content: flex-end;
  align-items: flex-end;
  padding: 0 50px;
}
</style>
