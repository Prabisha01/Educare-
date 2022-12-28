
// To delete the member 

function deleteData(id) {  
      var deleteStatement = "delete from teams where id=?";  
      db.transaction(function (tx) {  
          tx.executeSql(deleteStatement, [id], ShowData(), ShowErrorMessage);  
      });  
     ClearData();  
}   
function ClearData() {  
     firstName.value = '';  
     lastName.value = '';  
     expert.value = '';  
     email.value = '';  
     phone.value = '';  
     id.value = '';  
} 



// To Update the member

function UpdateData() {  
      var updateStatement = "UPDATE Emp SET firstName = ?, lastName = ?,city=?,state=? ,phone = ?,email=? WHERE id = ?";  
      db.transaction(function (tx) {   
          tx.executeSql(updateStatement, [firstName.value, lastName.value, city.value, state.value, phone.value, email.value, id.value], showdatacleardata, ShowErrorMessage);  
      });  
} 


// To add new course

  
function InsertData() {  
      var insertStatement = "insert into Emp (firstName, lastName,city,state,phone,email) values (?, ?, ?,?,?,?)";  
      db.transaction(function (tx) {   
          tx.executeSql(insertStatement, [firstName.value, lastName.value, city.value, state.value, phone.value, email.value], showdatacleardata, ShowErrorMessage);  
     });  
} 