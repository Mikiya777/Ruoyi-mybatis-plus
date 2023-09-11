<template>
  <div>
    <el-table
      v-loading="loading"
      :data="dataList"
      highlight-current-row
      style="width: 100%"
    >
      <el-table-column
        prop="studentName"
        label="学生姓名"
        :show-overflow-tooltip="true"
        align="center"
      ></el-table-column>
      <el-table-column
        prop="className"
        label="班级"
        :show-overflow-tooltip="true"
        align="center"
      ></el-table-column>
      <el-table-column
        prop="name"
        label="演练名称"
        :show-overflow-tooltip="true"
        align="center"
      ></el-table-column>
      <el-table-column
        prop="startTime"
        label="演练时间"
        align="center"
        :show-overflow-tooltip="true"
      ></el-table-column>
      <el-table-column
        prop="status"
        :show-overflow-tooltip="true"
        align="center"
        label="演练状态"
      >
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.status ? 'primary' : 'success'"
            disable-transitions
          >{{ scope.row.status ? "已结束" : "进行中" }}</el-tag
          >
        </template>
      </el-table-column>
      <el-table-column
        prop="score"
        label="总得分"
        align="center"
        :show-overflow-tooltip="true"
      ></el-table-column>
      <el-table-column
        prop="expId"
        label="操作"
        align="center"
        :show-overflow-tooltip="true"
      >
        <template slot-scope="scope">
          <div class="detail" @click="handleGoPage(scope.row.userId,scope.row.expId)">
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
            演练详情
          </div>
        </template>
      </el-table-column>
    </el-table>

    <div class="pagination">
      <el-pagination
        background
        @current-change="handlePageChange"
        @prev-click="handlePageChange"
        @next-click="handlePageChange"
        layout="prev, pager, next"
        v-show="pages > 0"
        :page-size="10"
        :page-count="pages">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import {getExperiment, getSchedule} from "@/api/student/api.js";
import {getExperimentByTeacher} from "@/api/teacher/api";
import {getDegital} from "@/api/teacher/api";

export default {
  name: "ExerciseAchievement",
  data() {
    return {
      dataList: [],
      loading: true,
      pages: 0,
      currentPage:1,
    };
  },
  created() {
    this.initValue();
    getExperimentByTeacher({ pageNum: 1 }).then((res) => {
      this.loading = false;
      this.dataList = res.data.experimentList.map((item) => {
        return {
          ...item,
          studentName:`${item.studentName}`,
          className:`${item.className}`,
          startTime: this.formatDateTime(item.startTime),
          name: `企业并购${item.expId}次演练`,
          score: `${item.objectiveScore}`,//后续再修改
        };
      });
      console.log(res, res);
    });
  },
  methods: {
    formatDateTime(a) {
      const date = new Date(a);
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, "0");
      const day = String(date.getDate()).padStart(2, "0");
      const hours = String(date.getHours()).padStart(2, "0");
      const minutes = String(date.getMinutes()).padStart(2, "0");

      return `${year}-${month}-${day} ${hours}:${minutes}`;
    },
    handleGoPage(u,e) {
      console.log(u,e)
      localStorage.setItem("detail_userid", u);
      localStorage.setItem("detail_expid",e);
      this.$router.push('/TeacherExerciseDetail/index')

      // localStorage.setItem("detail_expid", e);
      // this.$router.push('/ExerciseDetail/index')
    },
    initValue() {
      getExperimentByTeacher({ pageNum: this.currentPage })
        .then((res) => {
          this.pages = res.data.pages;
          this.dataList = res.data.experimentList.map((item) => {
            return {
              ...item,
              studentName:`${item.studentName}`,
              className:`${item.className}`,
              startTime: this.formatDateTime(item.startTime),
              name: `企业并购${item.expId}次演练`,
              score: `${item.objectiveScore}`,//后续再修改
            };
          });
          console.log(res);
        })
        .catch((e) => {
          console.log("e", e);
        });
    },
    handlePageChange(e) {
      this.currentPage = e;
      this.initValue();
    },
  },
};
</script>

<style scoped>
.detail {
  color: #40a9ff;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
}
.pagination {
  height: 60px;
  display: flex;
  justify-content: flex-end;
  align-items: flex-end;
  padding: 0 50px;
}
</style>
