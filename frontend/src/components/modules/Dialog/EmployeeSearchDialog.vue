<template>
    <modal name="employeeDialog" :draggable="true" :adaptive="true" :scrollable="true" width="75%" height="auto">
    <div clas="container">
    <div class="form-group form-inline" id="modal-header">
        担当者検索
        <br>
        名前を入力してください。
    </div>
    <div class="input-group mb-3" id="modal-search-form">
        <div class="input-group-prepend">
            <span class="input-group-text">担当者名（部分一致）</span>
        </div>
        <input v-model="employeeName" type="text" id="employee_name" placeholder="入力してください"/>
        <button @click="getEmployeeListByLikeName" class="btn btn-primary" id="button">検索</button>
    </div>
    <div id="modal-body">
    <table class="table table-bordered">
        <thead class="thead-lignt">
            <tr>
                <th id="dialog-employee-cd">担当者コード</th>
                <th id="dialog-employee-name">担当者名</th>
                <th id="dialog-select">選択</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="employee in employees" :key="employee.cd">
                <td id="dialog-employee-cd">{{ employee.cd }}</td>
                <td id="dialog-employee-name">{{ employee.name }}</td>
                <td id="dialog-select"><span @click="closeDialog(employee.cd, employee.name)" id="text-link">選択</span></td>
            </tr>
        </tbody>
    </table>
    </div>
    </div>
    </modal>
</template>

<script>

export default {
    data() {
        return {
            employees: null,
            employeeName: null
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
            this.$modal.show('employeeDialog');
        },
        closeDialog: function(employeeCd, employeeName) {
            this.$emit('select-employee', employeeCd, employeeName);
            this.$modal.hide('employeeDialog');
        }
    },
    created() {
        this.getAllEmployeeList();
    }
}
</script>
