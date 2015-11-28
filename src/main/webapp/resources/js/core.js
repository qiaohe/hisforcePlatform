$.ajaxSetup({
    cache:false,
    headers: {'x-auth-token':Cookies.get('token') || ''}
});
$.postJSON = function(url, data) {
    return $.ajax({
        url: url,
        data: data,
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        type: 'post'
    })
};
!(function () {
    var _loadFilter = function(data) {
        if (data.ret !== undefined) {
            var arr = data.data instanceof Array ? data.data : [];
            return {total: arr.length, rows: arr}
        } else if (typeof data.length == "number" && typeof data.splice == "function") {
            return {total: data.length, rows: data};
        } else {
            return data;
        }
    };
    $.extend($.fn.datagrid.defaults, {
        loadFilter: _loadFilter,
        method: 'get',
        singleSelect: true,
        fitColumns: true
    });
})();
var core = {
    cache: {},
    formatter: {
        gender: function(value) { return value == 1 ? '男' : '女' },
        department: function(value) {
            if (!core.cache.departments) {
                core.cache.departments = JSON.parse(sessionStorage.departments || '{}')
            }
            return core.cache.departments[value] || ''
        }
    }
};
sessionStorage.departments = JSON.stringify({1:'急诊科'});