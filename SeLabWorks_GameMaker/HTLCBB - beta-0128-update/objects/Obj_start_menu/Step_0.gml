/// @description Insert description here
// You can write your code in this editor
var pressButton;

pressButton = max(keyboard_check_pressed(vk_enter), gamepad_button_check_pressed(0, gp_start),0);
//pressButton = gamepad_button_check_pressed(0, gp_start)
if(pressButton==1) 
{
	with(inst_35EC0C2F)
	{
		draw_set_alpha(1)
		instance_destroy(inst_35EC0C2F);	
	
	}

	room_goto(rm_main_menu);
}

