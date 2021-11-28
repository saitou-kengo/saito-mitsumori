<template>
<div>
  <h1>見積詳細</h1>
  <router-link :to="{ name:'edit',params:{ id : $route.params.id }}">編集</router-link>
  <button v-on:click="deleteEstimate">削除</button>
  <estimates-datail-list/>
</div>
</template>

<script>
import EstimatesDatailList from '../modules/EstimatesDatailList.vue'
import axios from 'axios'

export default {
  components: {
    EstimatesDatailList
  },
  methods: {
    deleteEstimate: function() {
      axios
      .delete("/api/v1/estimates/{id}")
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log("エラー：" + err);
      })
    }
  }
}
</script>

<style>

</style>