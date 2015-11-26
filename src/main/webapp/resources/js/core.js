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