<template>
<div class="container">
  <h1>見積詳細</h1>
  <detail-estimate-form v-if="estimate"
    :id="estimateId"
    :estimate="estimate"
    :overAmount="overAmount"
  />
  <router-link :to="{ name:'edit',params:{ id : estimateId }}" tag="button" class="btn btn-success" id="button">編集</router-link>
  <button @click="deleteEstimate" class="btn btn-secondary" id="button">削除</button>
  <estimates-datail-list :details="details"/>
</div>
</template>

<script>
import EstimatesDatailList from '../modules/ListView/EstimatesDatailList.vue'
import DetailEstimateForm from '../modules/Form/DetailEstimateForm.vue'

export default {
  components: {
    EstimatesDatailList,
    DetailEstimateForm
  },
  data() {
    return {
      estimateId: this.$route.params.id,
      estimate: null,
      details: null,
    }
  },
  computed: {
    overAmount: function() {
      return this.estimate.budgetedAmount - this.estimate.amount;
    }
  },
  methods: {
    deleteEstimate: function() {
      this.$axios
      .delete('http://localhost:8080/api/v1/estimates/:id', {
        params: {
          id: this.estimateId
        }
      })
      .then(res => {
        alert('見積を削除しました')
        this.$router.push('/');
        console.log(res.data + 'delete Estimate');
      })
      .catch(err => {
        alert('見積の削除に失敗しました')
        console.log("エラー：" + err);
      })
    },
    getEstimateById: function() {
      this.$axios
      .get('http://localhost:8080/api/v1/estimates/:id', {
        params: {
          id: this.estimateId
        }
      })
      .then(res => {
        this.estimate = res.data;
        console.log('retrieve a Estimate by :id');
      })
      .catch(err => {
        console.log('エラー：' + err);
      })
    },
    getEstimateDetailsListById: function() {
    this.$axios
    .get('http://localhost:8080/api/v1/estimate-details/:id', {
        params: {
        id: this.estimateId
        }
    })
    .then(res => {
        this.details = res.data;
        console.log(res.data);
    })
    .catch(err => {
        console.log('エラー：' + err);
    });
    }
  },
  created: function() {
    this.getEstimateById();
    this.getEstimateDetailsListById();
  }
}
</script>
