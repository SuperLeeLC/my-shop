var App = function () {

    // iCheck
    var _masterCheckbox;
    var _checkbox;

    // 用于存放 ID 的数组
    var _idArray;

    /**
     * 私有方法，初始化 iCheck
     */
    var handlerInitCheckbox = function () {
        // 激活
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })

        // 获取控制端 checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');

        // 获取全部 checkbox 集合
        _checkbox = $('input[type="checkbox"].minimal');
    };

    /**
     *  checkbox 全选功能
     */
    var handlerCheckboxAll = function () {
        _masterCheckbox.on("ifClicked", function (e) {
            // 返回true 表示未选中
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }

            // 选中状态
            else {
                _checkbox.iCheck("check");
            }
        });
    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
      _idArray = new Array();

        // 将选中元素的 ID 放入数组中
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });

        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择任何数据项，请至少选择一项");
        }

        else {
            $("#modal-message").html("您确定删除数据项吗？");
        }

        $("#modal-default").modal("show");

        $("#btnModalOk").bind("click", function () {
            del();
        });

        /**
         * 当前私有函数的函数，删除数据
         */
        function del() {
            $("#modal-default").modal("hide");

            // 如果没有选择数据项的处理
            if (_idArray.length == 0) {
                // ...
            }

            // 删除操作
            else {
                setTimeout(function () {
                    $.ajax({
                        "url" : url,
                        "type" : "POST",
                        "async" : false,
                        "data" : {"ids" : _idArray.toString()},
                        "dataType" : "JSON",
                        "success" : function (data) {
                            //删除成功
                            if (data.status == 200) {
                                window.location.reload();
                            }

                            // 删除失败
                            else {
                                $("#btnModalOk").unbind("click");
                                $("#btnModalOk").bind("click", function () {
                                    $("#modal-default").modal("hide");
                                });

                                $("#modal-message").html(data.message);
                                $("#modal-default").modal("show");
                            }
                        }
                    });
                }, 500);
            }
        }
    };
    
    return {
        init: function() {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        getCheckbox: function () {
            return _checkbox;
        },

        deleteMulti : function (url) {
            handlerDeleteMulti(url);
        }
    }
}();

$(document).ready(function () {
    App.init();
});