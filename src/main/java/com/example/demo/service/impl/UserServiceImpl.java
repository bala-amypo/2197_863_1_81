@Override
public User registerUser(User user) {

    if (userRepository.existsByEmail(user.getEmail())) {
        throw new ValidationException("Email already in use");
    }

    if (user.getPassword() == null || user.getPassword().length() < 8) {
        throw new ValidationException("Password must be at least 8 characters");
    }

    if (user.getDepartment() == null) {
        throw new ValidationException("Department is required");
    }

    // 🔥 THIS WAS MISSING / WRONG
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    if (user.getRole() == null) {
        user.setRole("USER");
    }

    return userRepository.save(user);
}
