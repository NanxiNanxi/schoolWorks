/// @description Insert description here
// You can write your code in this editor
if max(keyboard_check_pressed(vk_enter),gamepad_button_check_pressed(0, gp_start),0)==1{
switch (current_index){
		case 0:
			room_goto(rm_main_menu);
		break
}
}