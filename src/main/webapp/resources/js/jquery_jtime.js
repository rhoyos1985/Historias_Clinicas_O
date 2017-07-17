/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function ($) {
        $.fn.jTime = function (o) {
        var d = { x: 'time-capa', ma: new Date(), i: 0 };
        var o = $.extend(d, o);
        o.ma = new Date(o.ma);

        var mHF = function () {
            var dt = new Date().toLocaleDateString();
            var ma = new Date(o.ma.getTime() + o.i * 1000);
            h = ma.getHours();
            m = ma.getMinutes();
            s = ma.getSeconds();
            if (h <= 9) h = '0' + h;
            if (m <= 9) m = '0' + m;
            if (s <= 9) s = '0' + s;
            hi ="Fecha y Hora: "+ dt + "," + h + ":" + m + ":" + s;
            $('#' + o.x).html(hi);
            o.i += 1;
        };

        return this.each(function () {
            o.x = $(this).attr('id');
            setInterval(mHF, 1000);
        });     
    };
})(jQuery);


