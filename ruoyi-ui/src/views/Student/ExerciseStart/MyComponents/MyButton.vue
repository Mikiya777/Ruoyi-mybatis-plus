<template>
  <div>
    <img  v-for="(item, index) in ImgList" :key="index" :src="item.imgUrl" class="buttonStyle"/>
  </div>
</template>

<script>
export default {
  name: "button",
  data() {
    return {
      ImgList:[
        {imgUrl:require("../MyComponents/assets/total/next_step.png")},
      ]
    }
  }
}
</script>

<style scoped>
  .buttonStyle{
    position: absolute;
    bottom: 20px;
    right: 20px;
  }
</style>
