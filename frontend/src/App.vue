<template>
<div id="app">
  <Header></Header>
<router-view />
</div>
</template>

<script>
import Header from './components/modules/Header.vue'

export default {
  components: {
    Header
  }
}
</script>

<style>
    header {
        background-color: #000;
        width: 100%;
        color: #fff;
        height: 50px;
        display: grid;
        margin-bottom: 80px;
    }

    h1 {
        justify-self: start;
        align-self: center;
        font-size: 20px;
        font-weight: normal;
    }
    
    #subtitle {
        justify-self: end;
        align-self: center;
        display: none;
    }
</style>
