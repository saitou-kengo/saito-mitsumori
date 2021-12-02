<template>
<div class="container">
    <div id="overlay" v-show="showFlag">
    <div id="dialog">
    <div class="form-group form-inline"  id="title">
        担当者検索
    </div>
    <br>
    <p>名前を入力してください。</p>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">担当者名（部分一致）</span>
        </div>
        <input v-model="employeeName" type="text" id="employee_name" placeholder="入力してください"/>
        <button @click="getEmployeeListByLikeName" class="btn btn-primary">検索</button>
    </div>
    <table class="table table-bordered">
        <thead class="thead-lignt">
            <tr>
                <th id="employeeCd">担当者コード</th>
                <th id="employeeName">担当者名</th>
                <th id="select">選択</th>
            </tr>
        </thead>
        <tbody>
        <div v-for="employee in employees" :key="employee.cd">
            <tr>
                <td id="employeeCd">{{ employee.cd }}</td>
                <td id="employeeName">{{ employee.name }}</td>
                <td id="select"><span @click="closeDialog(employee.cd, employee.name)">選択</span></td>
            </tr>
        </div>
        </tbody>
    </table>
    </div>
    </div>
</div>
</template>

<script>

export default {
    data() {
        return {
            employees: null,
            employeeName: null,
            showFlag: false
        }
    },
    methods: {
        getAllEmployeeList: function() {
            this.$axios
            .get('http://localhost:8080/api/v1/employees')
            .then((res) => {
                this.employees = res.data;
            })
            .catch((err) => {
                console.log("エラー：" + err);
            });
        },
        getEmployeeListByLikeName: function() {
            this.$axios
            .get('http://localhost:8080/api/v1/employees/name/:cd', {
                params: {
                    name: this.employeeName
                }
            })
        .then(res => {
            this.employees = res.data;
        })
        .catch(err => {
            console.log("エラー：" + err);
        })
        },
        showDialog: function() {
            this.showFlag = true;
        },
        closeDialog: function(employeeCd, employeeName) {
            this.$emit('select-employee', employeeCd, employeeName);
            this.showFlag = false;
        }
    },
    created() {
        this.getAllEmployeeList();
    }
}
</script>

<style>
table {
    margin: auto;
}

tbody {
    overflow: scroll;
}

#employeeCd {
    width: 25%;
}

#employeeName {
    width: 50%;
}

#select {
    width: 25%;
}

#overlay{
    z-index: 1;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0,0,0,0.5);
    display: flex;
    align-items: center;
    justify-content: center;
}

#dialog{
    z-index: 2;
    width: 50%;
    padding: 1em;
    background: #fff;
}
</style>
