<template>
<div>
  <h1>見積編集</h1>
  <InputEstimateForm/>
  <InputItemForm/>
  <input type="button" value="見積更新" id="updata"/>
  <EstimatesDatailList/>
</div>
</template>

<script>
import InputEstimateForm from '../modules/InputEstimateForm.vue'
import InputItemForm from '../modules/InputItemForm.vue'
import EstimatesDatailList from '../modules/EstimatesDatailList.vue'

export default {
  components: {
    InputEstimateForm,
    InputItemForm,
    EstimatesDatailList
  }

}
</script>

<style>

</style>