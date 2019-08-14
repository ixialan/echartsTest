/*
jQuery Pop Menu
Version: beta
Author: Guc. http://www.gucheen.pro
Based on jQuery 2.0.3
*/

(function ($) {
	
    $.fn.popmenu = function (options) {
    	
        var settings = $.extend({
            'controller': true,
            'width': '400px',
            'background': '#34495e',
            'focusColor': '#1abc9c',
            'borderRadius': '10px',
            'top': '50',
            'left': '0',
            'iconSize': '100px',
            'color': '#fff',
            'border': '0px'
        }, options);
        if (settings.controller === true) {
            var temp_display = 'none';
        } else {
            var temp_display = 'block';
        }
        var tar = $(this);
        var tar_body = tar.children('ul');
        var tar_list = tar_body.children('li');
        var tar_a = tar_list.children('a');
        var tar_ctrl = tar.children('.pop_ctrlx');

        function setIt() {
            tar_body.css({
                'display': temp_display,
                'position': 'absolute',
                'margin-top': -settings.top,
                'margin-left': -settings.left,
                'background': settings.background,
                'width': settings.width,
                'float': 'left',
                'padding': '0',
                'border-radius': settings.borderRadius,
                'border': settings.border
            });
            tar_list.css({
                'display': 'block',
                'color': settings.color,
                'float': 'left',
                'width': settings.iconSize,
                'height': settings.iconSize,
                'text-align': 'center',
                'border-radius': settings.borderRadius
            });
            tar_a.css({
                'text-decoration': 'none',
                'color': settings.color
            });
            tar_ctrl.hover(function () {
                tar_ctrl.css('cursor', 'pointer');
            }, function () {
                tar_ctrl.css('cursor', 'default')
            });
            tar_ctrl.click(function (e) {
                e.preventDefault();
                
                // 弹出菜单修改Start
                var x = event.clientX;  
                var y = event.clientY;
                
//                alert(event.clientX);
                
//                alert(x+", "+y);
                
                if (1200 < x) {
                	x = -300;
                } else {
                	x = x - x;
                }
                y = y - y + 80;;
                
//                var myEvent = event||window.event;
//                var xaix = myEvent.clientX;
//                if (1200 < xaix) {
//                	xaix = xaix - 300;
//                }
//                $("#demo_ul_1").css("left", xaix + "px").css("top", myEvent.clientY + 80 + "px").css("z-index", "99");
//                $("#demo_ul_2").css("left", xaix + "px").css("top", myEvent.clientY + 80 + "px").css("z-index", "99");
//                $("#demo_ul_3").css("left", xaix + "px").css("top", myEvent.clientY + 80 + "px").css("z-index", "99");
//                $("#demo_ul_4").css("left", xaix + "px").css("top", myEvent.clientY + 80 + "px").css("z-index", "99");
//                $("#demo_ul_5").css("left", xaix + "px").css("top", myEvent.clientY + 80 + "px").css("z-index", "99");
//                $("#demo_ul_6").css("left", xaix + "px").css("top", myEvent.clientY + 80 + "px").css("z-index", "99");
                
                $("#demo_ul_1x").css("left", x + "px").css("top", y + "px").css("z-index", "999");
                $("#demo_ul_2x").css("left", x + "px").css("top", y + "px").css("z-index", "999");
                $("#demo_ul_3x").css("left", x + "px").css("top", y + "px").css("z-index", "999");
                $("#demo_ul_4x").css("left", x + "px").css("top", y + "px").css("z-index", "999");
                $("#demo_ul_5x").css("left", x + "px").css("top", y + "px").css("z-index", "999");
                $("#demo_ul_6x").css("left", x + "px").css("top", y + "px").css("z-index", "999");
//                var offset=$("#demo_ul_1").offset();
//                $("#demo_box_1").css("left",offset.left+"px").css("top",offset.top+"px");
//                alert(offset);
                
                // 弹出菜单修改End
                
                tar_body.show('fast');
                $(document).mouseup(function (e) {
                    var _con = tar_body; //ul
                    if (!_con.is(e.target) && _con.has(e.target).length === 0) {
                        _con.hide();
                    }
                    //_con.hide(); some functions you want
                });
            });
            tar_list.hover(function () { //li
                $(this).css({
                    'background': settings.focusColor,
                    'cursor': 'pointer'
                });
            }, function () {
                $(this).css({
                    'background': settings.background,
                    'cursor': 'default'
                });
            });
        }
        return setIt();

    };

}(jQuery));
