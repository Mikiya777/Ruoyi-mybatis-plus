<template>
  <div>
    <div class="circle-container">
      <div class="circle">
          <span class="container">
          </span>
      </div>
      <div class="content">
        {{name}}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "childBlock",
  data(){
    return{

    }
  },

  props:['name'],
  created() {

  }
}
</script>

<style scoped>
.circle-container {
  display: inline-flex;
  align-items: center;
}

.circle {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  background-color: skyblue;
  display: flex;
  justify-content: center;
  align-items: center;
}

.container {
  color: white;
}

.content {
  flex-grow: 1;
  padding-left: 10px;
}
</style>
