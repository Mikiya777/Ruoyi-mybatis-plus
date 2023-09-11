<template>
  <div>
    <div>
      <div class="box">
        <div class="grid-container">
          <!-- 第一个子模块 -->
          <child-block v-for="obj in list" :key="obj.id" :name="obj.name"/>
          <!-- 在这里添加更多子模块 -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import childBlock from "@/views/Student/ExerciseStart/navigator/childBlock.vue";
export default {
  name: "navigator",
  components: {
    childBlock
  },
  data() {
    return {
      list: [],
    }
  },
  props: {
    questionObj: {
      type: Object,
      default: () => ({}) // 设置默认值为空对象，防止未传递数据时出错
    }
  },
  mounted() {
    // 检查是否已包含相同的数据
    if (!this.list.some(item => item.id === this.questionObj.id)) {
      this.list.push(this.questionObj);
    }
    console.log(this.list);
  },
  watch: {
    questionObj: {
      deep: true, // 深度监听对象的变化
      immediate: true,
      handler(newVal) {
        // 检查是否已包含相同的数据
        if (!this.list.some(item => item.id === newVal.id)) {
          this.list.push(newVal);
        }
      }
    }
  }
}
</script>

<style scoped>
.box {
  background-color: rgba(255, 255, 255, .8);
  width: 100%;
  height: 70px;
  overflow-x: auto; /* 使用水平滚动条 */
  overflow-y: hidden;
  white-space: nowrap; /* 防止子模块换行 */
  position: relative;
}

.grid-container {
  display: inline-flex;
  gap: 10px; /* 列之间的间隔 */
  padding: 10px; /* 可选的内边距 */
  min-width: 100%; /* 让所有子模块的宽度超过容器宽度时自动换行 */
}

</style>
