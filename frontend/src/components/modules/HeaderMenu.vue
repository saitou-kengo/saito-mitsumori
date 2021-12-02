<template>
<div class="container">
<header id="header">
    <link href='https://css.gg/layout-list.css' rel='stylesheet'>
    <link href='https://css.gg/add.css' rel='stylesheet'>
    <div class="title">
        販売管理システム
        <p>SALEWORKERS</p>
    </div>
    <div class="menu form-group form-inline">
        <ul id="nav">
            <li><i class="gg-layout-list"></i><router-link to="/">見積検索</router-link></li>
            <li><i class="gg-add"></i><router-link to="/estimates/new">見積登録</router-link></li>
        </ul>
    </div>
</header>
</div>
</template>

<style>
    #header {
        background-color: black;
        width: auto;
        height: 30%;
        padding: 0 30px 10px 100px;
        margin-bottom: 25px;
    }

    .title {
        color: white;
        font-size: 24pt;
        font-weight: bold;
        margin-top: 15px;
    }

    #subtitle {
        font-size: 12pt;
    }


    .menu {
        color: gray;
        float: float;
    }

    #nav li {
        width: 100px;
        float: left;
        list-style: none;
        text-decoration: none;
    }
</style>
