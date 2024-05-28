def remove_special_chars_and_numbers(input_string):
    # Define special characters and numbers
    special_chars_and_numbers = '0123456789!"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~'
    
    # Remove special characters and numbers from the input string
    cleaned_string = ''.join(char for char in input_string if char not in special_chars_and_numbers)
    
    return cleaned_string

def polyalphabetic_cipher(input_string, key):
    # Define the alphabet for both uppercase and lowercase letters
    uppercase_alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    lowercase_alphabet = 'abcdefghijklmnopqrstuvwxyz'
    
    # Remove special characters and numbers from the input string
    cleaned_string = remove_special_chars_and_numbers(input_string)
    
    # Initialize the output string
    output_string = ''
    
    # Iterate over each character in the input string
    for char in cleaned_string:
        if char.isupper():
            # Find the index of the character in the uppercase alphabet
            index = uppercase_alphabet.find(char)
            
            # Shift the character by the key value
            shifted_index = (index + key) % 26
            
            # Add the shifted character to the output string (maintaining case)
            output_string += uppercase_alphabet[shifted_index]
        elif char.islower():
            # Find the index of the character in the lowercase alphabet
            index = lowercase_alphabet.find(char)
            
            # Shift the character by the key value
            shifted_index = (index + key) % 26
            
            # Add the shifted character to the output string (maintaining case)
            output_string += lowercase_alphabet[shifted_index]
        else:
            # If the character is not a letter, ignore it
            pass
            
    return output_string

# Get input string and key value from the user
input_string = input("Enter the input string: ")
key = int(input("Enter the key value (an integer): "))

# Encrypt the input string using the polyalphabetic cipher
encrypted_string = polyalphabetic_cipher(input_string, key)

# Print the encrypted string without spaces
print("Encrypted string:", encrypted_string)
