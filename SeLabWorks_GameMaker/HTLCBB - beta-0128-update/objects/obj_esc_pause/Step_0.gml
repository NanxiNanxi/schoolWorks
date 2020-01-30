/// @description Insert description here
// You can write your code in this editor
if(gamepad_button_check_pressed(0,gp_shoulderlb)){
room_persistent = true; 
global.current_room = room
room_goto(rm_pause); 
}