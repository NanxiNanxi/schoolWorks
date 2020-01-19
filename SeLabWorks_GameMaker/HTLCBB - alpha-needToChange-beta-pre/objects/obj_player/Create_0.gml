horSpeed = 0;
verSpeed = 0;
myGravity = GRAVITY_RESET;

charater = noone;
myPlayer = noone;

controller = CON_KEYBOARD;

myEnemy =PLAYER0;

myStatus = STATE_UNLOCK;

spr_idle = 0;
spr_to_left=0;
spr_to_right = 0;
spr_crouch = 0;
spr_jump = 0;
spr_fall = 0;
spr_attack[0] =0;
spr_attack[1]=0;
spr_attack[2]=0
frameCounter = 0

isLose1stPlay = true
isWin1stPlay = true

//isTimesUp = false;

toLeft=0;
toRight =0;
up = 0;
down = 0;
punch = 0;
block = 0;
kick = 0;
isDucking = false;

hit = 0;
hp = 300;
hp_max = hp;
flash = 0;
isLose = false;
isCanBeAttacked = true;
isBlock = false;
isJumpAttack = false;
specialAttackCounter = 0;
is1stSpecialCounterAdded = false;
is2ndSpecialCounterAdded = false;
is3rdSpecialCounterAdded = false;

isSpecialAttackUsed = 0;

onTheGround = false;
can_attack = true;
attack_type = ATTACK_KICK;



