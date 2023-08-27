<template>
  <div>
    {{ title }}
    <ul v-for="indexA in time "  :key="indexA" class="ul-box">
        <template  v-for="(item , index ) in splitData[indexA-1]" >
        <show-box  :isShow="true" :key="index" :content="item.content"> </show-box>
      </template>
    </ul>



  </div>
</template>

<script>
import ShowBox from "@/views/Student/ExerciseAchievement/showBox.vue";

export default {
  name: "ExerciseAchievement",
  components: {ShowBox},

  data() {
    return {
      title: "成绩",
      dataList:[],
      splitData:{},
      time:0
    }
  },
  created() {
    this.dataList = [ {id:0,content:'333'},{id:1,content:'222'},{id:2,content:'123'},{id:2,content:'<img src="./bad.png"><img>'} ]
    this.time = Math.ceil( this.dataList.length / 4 +1)
    for (let i = 0; i < this.dataList.length; i += 4) {
      const group = this.dataList.slice(i, i + 4);
      this.splitData[i / 4] = group;
    }
    console.log(   0/4 )
  }

}
</script>

<style scoped>
.ul-box{
  display: flex;
  width: 100%;
}
</style>
