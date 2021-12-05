<template>
<div class="container">
  <detail-estimate-form
    v-if="estimate"
    :id="estimateId"
    :estimate="estimate"
    :overAmount="overAmount"
  />
  <div class="row margin-15">
    <div class="col">
      <router-link :to="{ name:'edit',params:{ id : estimateId }}" tag="button" class="btn btn-success" id="button">編集</router-link>
      <button @click="deleteEstimate" class="btn btn-secondary" id="button">削除</button>
    </div>
  </div>
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
        console.log(res.data + 'delete Estimate');
        this.$router.push('/');
      })
      .catch(err => {
        console.log('Error：' + err);
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
        console.log('Error：' + err);
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
          console.log('retrieve a EstimateDetail by :id');
      })
      .catch(err => {
          console.log('Error：' + err);
      });
    }
  },
  created: function() {
    this.getEstimateById();
    this.getEstimateDetailsListById();
  }
}
</script>
