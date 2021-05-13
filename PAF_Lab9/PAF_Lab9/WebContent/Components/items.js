
$(document).ready(function(){ 

if ($("#alertSuccess").text().trim() == "null" ) { 
 $("#alertSuccess").hide(); 
 } 
 $("#alertError").hide(); 
}); 





// SAVE ============================================
$(document).on("click", "#btnSave", function(event) { 
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
// Form validation-------------------
var status = validateItemForm(); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
// If valid------------------------
 $("#formItem").submit(); 
}); 
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidGrant_Application_IDSave").val($(this).closest("tr").find('#hidGrant_Application_IDUpdate').val()); 
 $("#Title").val($(this).closest("tr").find('td:eq(0)').text()); 
 $("#Full_Name").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#Email").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#Phone").val($(this).closest("tr").find('td:eq(3)').text());
 $("#Research_category").val($(this).closest("tr").find('td:eq(4)').text()); 
 $("#Budget").val($(this).closest("tr").find('td:eq(5)').text());  
 $("#Introduction").val($(this).closest("tr").find('td:eq(6)').text());  
}); 
// CLIENT-MODEL================================================================
function validateItemForm() 
{ 
// Title
if ($("#Title").val().trim() == "") 
 { 
 return "Insert Title."; 
 } 
// Full Name
if ($("#Full_Name").val().trim() == "") 
 { 
 return "Insert Full Name."; 
 }
//Email-------------------------------
if ($("#Email").val().trim() == "") 
 { 
 return "Insert Email."; 
 } 
 //Phone-------------------------------
if ($("#Phone").val().trim() == "") 
 { 
 return "Insert Phone."; 
 } 
 //Research category-------------------------------
if ($("#Research_category").val().trim() == "") 
 { 
 return "Insert Research category."; 
 } 
 //Budget-------------------------------
if ($("#Budget").val().trim() == "") 
 { 
 return "Insert Budget."; 
 } 

// Introduction------------------------
if ($("#Introduction").val().trim() == "") 
 { 
 return "Insert Introduction."; 
 } 
return true; 
}
