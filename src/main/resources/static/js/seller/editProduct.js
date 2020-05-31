/*
* 自定义的js代码,用于编辑商品
*
* */


$("#submit_EditProduct").click(function(){
    /* 检查输入框是否符合正则表达式 */

    /* 检查ajax校验名字是否可用后的标记 */

    /*因为涉及到文件的处理,无法直接用form封装到pojo中,所以先使用js代码来封装数据*/
    var product={};
    // product.productId= null; 需要从页面获取商品id;
    product.productName = $("#productName").val();
    product.productDesc= $("#productDesc").val();
    product.normalPrice= $("#normalPrice").val();
    product.productId= $("#productId").val();
    product.productCategoryId= $("#productCategorySel option:selected").attr("value");

    var productImg = $("#inputFile")[0].files[0]; //需要在控制层处理一下用户没有上传文件的情况
    var formData = new FormData($("#inputFile")[0]);
    formData.append("productStr",JSON.stringify(product));
    formData.append("productImg",productImg);

    $.ajax({
        url:"/seller/ajax/product/update",
        type:"POST",
        data:formData,
        async: false,
        contentType:false,
        processData:false,
        cache:false,
        success:function(result){
                alert(result.msg);
        }
    });

});



