<template>
<div> 

<input  id="search" class="bar7" type="text" placeholder="搜索...">
  <el-table
    :data="tableData"
    style="width: 100%"
    :row-class-name="tableRowClassName">
    <el-table-column
      prop="number"
      label="学号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="ident"
      label="身份证">
    </el-table-column>

     <el-table-column 
      label="操作">
      <a href="#/">操作</a>
    </el-table-column>

  </el-table>

</div>

  
</template>

<style>
	.bar7 {
		height: 40px;
		margin: 0 auto;
		width:90%;
		border-radius:42px;
		border:2px solid #324B4E;
		background:#F5F5F5;
		padding-left: 20px;
			}
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>

<script>
  export default {
    methods: {
      tableRowClassName({row, rowIndex}) {
        if (rowIndex === 1) {
          return 'warning-row';
        } else if (rowIndex === 3) {
          return 'success-row';
        }
        return '';
      }
    },
    data() {
      return {
        tableData: [{
          number: '2016-05-02',
          name: '王小虎',
          ident: '上海市普陀区金沙江路 1518 弄',
        }]
      }
    }
  }
</script>