.data
	msg: .asciiz "Podaj dlugosc ciagu liczb\n"
	msg1: .asciiz "Podaj liczby"
	a: .asciiz "a"
	s: .asciiz " "

	arrayz: .space 100
	
.text

main:
	
	#index at $t1, pointer at $t0
	
	li $t0, 0
	li $t1, 0
	li $s1, 1
	
loop:

	beq $t1, 5, output
	
	sw $s1,arrayz($t0)
	add $t0, $t0, 4
	add $t1, $t1, 1
	add $s1, $s1, 1
	
	j loop
	
output:
	li $t2, 0
	j outputt
	
outputt:
	
	beq $t2, 5, end
	
	sub $t0, $t0, 4
	add $t2, $t2, 1
	
	li $v0, 1
	lw $t4, arrayz($t0)
	move $a0, $t4
	syscall
	
	li $v0, 4
	la $a0, s
	syscall
	
	j outputt
	
end:
	li $v0, 10
	
	
	
	
	