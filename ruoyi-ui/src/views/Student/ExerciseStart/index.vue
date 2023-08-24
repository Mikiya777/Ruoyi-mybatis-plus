<template>
  <div class="box-div">

      <img src="./MyComponents/assets/total/01.png" alt="img" @click="changePage">
  </div>
</template>

<script>
export default {
  name: "ExerciseStart",
  data() {
    return {
    }
  },

  methods:{
    changePage: function (){
      this.$router.push("/one")
    },

    /*
    transQuery:function (){
      const myid=this.id
      this.$router.push({
        path: "/one",
        query: {
          id:myid
        }

        //axios请求
      });
    }
    */
  }
}
</script>

<style scoped>
.box-div{
  height: calc(100vh - 84px);
  width: 100%;
  background-color: red;
}

img{
  height: 100%;
  width: 100%;
  object-fit: fill;
}
</style>
