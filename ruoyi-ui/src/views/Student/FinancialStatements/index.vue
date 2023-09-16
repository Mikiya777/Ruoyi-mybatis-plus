<template>
  <div class="box-div">
    <img src="@/assets/fortune1.png" alt="img">
    <img src="@/assets/fortune2.png" alt="img">
    <img src="@/assets/fortune3.png" alt="img">
  </div>
</template>

<script>
export default {
  name: "FinancialStatements",
  data() {
    return {
      title: "财务报表",
    }
  }
}
</script>

<style scoped>
.box-div {
  height: calc(100vh - 84px);
  width: 100%;
  overflow: auto;
}

img {
  width: 100%;
  object-fit: fill;
}
</style>
