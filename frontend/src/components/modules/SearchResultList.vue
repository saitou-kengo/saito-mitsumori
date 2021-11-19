<template>
<div>
    <span id="index">検索結果一覧</span>
    <br>
    <table>
        <tr>
            <th>見積番号</th>
            <th>案件名</th>
            <th>ステータス</th>
            <th>顧客名</th>
            <th>担当者名</th>
            <th>予算金額</th>
            <th>見積金額</th>
            <th>詳細</th>
            <th>編集</th>
        </tr>
        <tr>
            <td>1</td>
            <td>テスト</td>
            <td>見積中</td>
            <td>さいとう</td>
            <td>けんご</td>
            <td>200</td>
            <td>150</td>
            <td><router-link :to="{name:'detail',params:{id:1}}">詳細</router-link></td>
            <td><router-link :to="{name:'edit',params:{id:1}}">編集</router-link></td>
        </tr>
    </table>
</div>
</template>

<script>
export default {

}
</script>

<style>
#index {
    display: flex;
    align-items: center;
    justify-content: center;
}

#index:before, .catch:after {
    border-top: 1px solid;
    content: "";
    width: 3em;
}

#index:before {
    margin-right: 1em;
}

#index:after {
    margin-left: 1em;
}
</style>