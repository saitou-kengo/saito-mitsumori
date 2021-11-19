<template>
<div>
  <h1>見積登録</h1>
  <InputEstimateForm/>
  <InputItemForm/>
  <input type="button" value="見積登録" id="register"/>
</div>
</template>

<script>
import InputEstimateForm from '../modules/InputEstimateForm.vue'
import InputItemForm from '../modules/InputItemForm.vue'

export default {
  components: {
    InputEstimateForm,
    InputItemForm
  }

}
</script>

<style>

</style>