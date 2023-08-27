<template>
    <li class="li-box">
      <el-popover
        ref="popover"
        placement="bottom"
        title="标题"
        width="200"
        trigger="click"
        <template   > <img src="./bad.png"/> </template>
        <el-button class="button-box" slot="reference">click 激活</el-button>
      </el-popover>
      <div v-show="isShow" class="box-span"></div>

    </li>
</template>

<script>
export default {
  name: "showBox",
  props:{
    isShow: {
      type:Boolean,
      default:true
    },
    content:{

    }
  },
  data() {
    return {

    }
  }
}
</script>

<style scoped>

.li-box{
  position: relative;
  width: 25%;
  list-style: none;
  padding: 0;
}

.button-box{
  width: 80%;
}

.box-span{
  height: 1px;
  border-top: 1px solid #1b9fe8;
  width: 20%;
  position: absolute;
  right: 0;
  transform: translateY(-50%);
  top: 50%;
}
</style>
