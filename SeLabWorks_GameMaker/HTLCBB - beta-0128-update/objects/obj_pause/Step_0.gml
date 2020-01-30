/// @description Insert description here
// You can write your code in this editor

if max(keyboard_check_pressed(ord("W")), 0 ,keyboard_check_pressed(vk_up),gamepad_button_check_pressed(0, gp_padu))==1{
	current_index--;
	if current_index <0 current_index = array_length_1d(menu)-1
}


if  max(keyboard_check_pressed(ord("S")), 0 ,keyboard_check_pressed(vk_down),gamepad_button_check_pressed(0, gp_padd))==1{
	current_index++;
	if current_index > array_length_1d(menu)-1 current_index = 0;
}



if max(keyboard_check_pressed(vk_enter),gamepad_button_check_pressed(0, gp_start),0)==1{
	switch (current_index){
		case 0:
			global.isPausedPressed = true
			room_goto(global.current_room)
		break
		
		case 1:
			global.isNeedToGoMain = true;
			room_goto(global.current_room)
			
			//room_goto(rm_main_menu);
			
		break;
		
		case 2:
		
			game_end();
		break
		
		
	}
}

