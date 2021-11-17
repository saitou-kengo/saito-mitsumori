<template>
<header>
    <h1>{{ title }}</h1>
    <div id="subtitle">{{ subtitle }}</div>
    <div id="search">
        <router-link to="/">{{ search }}</router-link>
    </div>
    <div id="register">
        <router-link to="/new">{{ register }}</router-link>
    </div>
</header>
</template>

<script>
export default {
    name: 'header',
    data() {
        return {
            title: "販売管理システム",
            subtitle: "SALESWORKERS",
            search: "見積検索",
            register: "見積登録"
        }
    }
}
</script>

<style>
    header {
        background-color: #000;
        color: #fff;
        height: 50px;
        display: grid;
        grid-template-columns: 20px 1fr 20px;
        grid-template-rows: 1fr;
        margin-bottom: 80px;
    }

    header > * {
        grid-row: 1;
        grid-column: 2;
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