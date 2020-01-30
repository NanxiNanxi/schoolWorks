
//set gravity
verSpeed += myGravity;

//horizontal collision
if place_meeting(x+horSpeed, y, obj_collision_wall){
	while (!place_meeting(x+sign(horSpeed),y,obj_collision_wall)){
		x +=sign(horSpeed)
	}
	horSpeed = 0;

}
//vertical

onTheGround = place_meeting(x, y+verSpeed, obj_collision_wall);

if onTheGround{
	while (!place_meeting(x,y+sign(verSpeed),obj_collision_wall)){
		y +=sign(verSpeed)
	}
	verSpeed = 0;

}

x += horSpeed;
y += verSpeed;