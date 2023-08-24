<template>
  <div>
    three

    <div>
      this is my query from other route
      {{mydata}}
    </div>
  </div>
</template>

<script>
export default {
  name: "three",
  data(){
    return{
      mydata:this.$route.query.id
    }
  },
  created() {
    const id = this.$route.query.id;
    alert(id)
    // axios.get({
    //   url:''
    // })
    // axios{
    //   method:'get',
    //     url:''
    // }
  }
}
</script>

<style scoped>

</style>
