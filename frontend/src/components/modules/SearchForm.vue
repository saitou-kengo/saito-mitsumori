<template>
<dev>
    <span id="index">検索条件</span>
    <br>
    <span>
        <label for="estimate_id">見積番号</label>
        <input type="text" class="search_box" id="estimate_id"/>
        <input type="button" value="検索" id="search"/>
    </span>
    <br>
    <span>
        <label for="estimate_name">案件名</label>
        <input type="text" class="search_box" id="estimate_name"/>
        <input type="button" value="検索" id="search"/>
    </span>
    <br>
    <span>
        <label for="estimate_status">見積ステータス</label>
        <select name="estimate_status" id="estimate_status">
            <option value="1">見積中</option>
            <option value="2">見積完了</option>
            <option value="3">受注済み</option>
        </select>
        <input type="button" value="検索" id="search"/>
    </span>
    <br>
    <span>
        <label for="customer_name">顧客名</label>
        <input type="text" class="search_box" id="customer_name"/>
        <input type="button" value="顧客選択" id="customer_select"/>
        <input type="button" value="クリア" id="clear"/>
        <input type="button" value="検索" id="search"/>
    </span>
    <br>
    <span>
        <label for="manager_name">担当者名</label>
        <input type="text" class="search_box" id="manager_name"/>
        <input type="button" value="担当者選択" id="manager_select"/>
        <input type="button" value="クリア" id="clear"/>
        <input type="button" value="検索" id="search"/>
    </span>
    <br>
</dev>
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

label {
    background-color:rgb(219, 219, 219);
}



</style>