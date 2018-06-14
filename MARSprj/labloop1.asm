.data
	msg: .asciiz "Podaj dlugosc ciagu liczb\n"
	msg1: .asciiz "Podaj liczby"
	a: .asciiz "a"
	s: .asciiz " "

	arrayz: .word 1:25
	
.text

main:
	li $v0, 4
	la $a0, msg
	syscall
	
	li $v0, 5
	syscall
	move $t0, $v0
	
	la $t3, arrayz
	move $t6, $t3

		
	
	j inputt
	
end:
	li $v0, 10

inputt:
	li $t1, 0
	li $t7, 0 # t7 licznik liczb != 0

input:
	beq $t1, $t0, output
	
	li $v0, 5
	syscall
	move $t4, $v0
	
	sw $t4, ($t3)
	addi $t3, $t3, 4
	
	addi $t1, $t1, 1
	
	j input
	
output:
	move $t3, $t6
	li $t5, 0
outputt:

	beq $t5, $t0, end
	
	li $v0, 1
	lw $a0, ($t3)
	syscall
	
	addi $t3, $t3, 4
	addi $t5, $t5, 1
	
	j outputt
	

	


	
	
	
	
	
	
	
	
	