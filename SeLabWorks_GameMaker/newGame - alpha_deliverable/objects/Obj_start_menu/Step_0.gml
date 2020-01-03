/// @description Insert description here
// You can write your code in this editor
var pressButton;
pressButton = max(keyboard_check_pressed(vk_enter), gamepad_button_check_pressed(0, gp_start),0);
if(pressButton==1) room_goto(rm_main_menu);

