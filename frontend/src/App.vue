<template>
<div id="app">
  <header-menu/>
  <router-view/>
</div>
</template>

<script>
import HeaderMenu from './components/modules/HeaderMenu.vue'

export default {
    components: {
        HeaderMenu
    }
}
</script>

<style>
@import './css/styles.css';
</style>
