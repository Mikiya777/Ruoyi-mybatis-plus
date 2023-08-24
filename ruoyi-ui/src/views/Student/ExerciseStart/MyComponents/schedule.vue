<template>
  <div class="schedule">
    <div v-for="(item, index) in mylistdata" :key="index" class="item">
      {{ item.name }}
      <div class="progress">
        <div class="progress-bar" :style="{ width: item.progress + '%' }"></div>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  name: "schedule",
  data(){
    return{
      mylistdata:[
        {
          name:"hello"
        },
        {
          name:"wdnmd"
        },
        {
          name:"114514"
        },
        {
          name:"1919810"
        },
        {
          name:"hello"
        },
        {
          name:"wdnmd"
        },
        {
          name:"hello"
        },
        {
          name:"wdnmd"
        },
        {
          name:"hello"
        },
        {
          name:"wdnmd"
        },
        {
          name:"hello"
        },
        {
          name:"wdnmd"
        },
      ]

    }
  },
  props:[],
  methods:{

  },
}
</script>

<style>
  @import "boxStyle.css";
</style>
