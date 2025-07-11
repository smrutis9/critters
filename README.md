# Critters Simulation Project

## Overview
A paired programming project implementing an interpreter for a simulated ecosystem where critters behave according to species-specific instructions. The project includes building an interpreter to read behavior files, execute critter actions, and create custom critters for competition.

## Features

### Core Components
- **Interpreter Implementation**: Reads behavior files and executes critter instructions
- **Species Programming Language**: Supports 20+ commands for critter behavior
- **Test Harness**: Comprehensive testing framework for validation
- **Custom Critter Design**: Strategic critter creation for CritterFest competition

### Supported Commands

#### Movement & Actions
- `hop`: Move forward if space is empty
- `left/right`: Turn 45 degrees
- `infect [n]`: Convert enemy to ally
- `eat`: Consume enemy for energy boost

#### Control Flow
- `go n`: Jump to line n (absolute/relative)
- `ifrandom n`: 50% chance jump
- `ifhungry/ifstarving n`: Conditional jumps based on hunger

#### Environmental Checks
- `ifempty/ifally/ifenemy/ifwall b n`: Check adjacent squares
- `ifangle b1 b2 n`: Compare heading differences

#### Register Operations
- `write r v`: Store value in register
- `add/sub r1 r2`: Arithmetic operations
- `inc/dec r1`: Increment/decrement
- `iflt/ifeq/ifgt r1 r2 n`: Conditional comparisons

## Implementation Details

### loadSpecies Method
- Reads critter behavior files using Scanner
- Creates ArrayList of behavior instructions
- Returns CritterSpecies object with name and code

### executeCritter Method
- Executes behavior code line by line
- Manages critter state and registers
- Handles all 20+ command types
- Tracks execution position between turns

## Testing Approach

### White Box Testing
- Individual method testing through custom Test Harness
- Command execution verification
- Order of operations validation
- Edge case handling

### Test Cases
- Register bounds checking (1-10)
- Command spelling validation
- Index boundary verification
- Parameter count validation

## Custom Critter Strategy
Our critter "Bammi" employs an aggressive strategy:
1. Detect enemies directly ahead
2. Check for empty spaces
3. Navigate with right turns
4. Prioritize infection when satisfied
5. Eat when hungry for survival

## Results & Observations
- Rover dominated in multi-species battles
- Custom critter unexpectedly defeated Rover
- Position-based advantages observed
- Random outcomes with identical critters

## Social Impact
Competition in technology can drive innovation but may also foster toxicity. While healthy competition motivates improvement, excessive focus on beating others can lead to:
- Discouragement when falling behind
- Unhealthy comparison culture
- Mental health impacts
- Reduced collaboration

## Technical Challenges
1. File parsing complexity - Solved with separate name/code readers
2. Switch statement limitations - Converted to if-statement approach
3. Whitespace handling - Refined substring operations
4. Index tracking in loops - Replaced for-loops with while-loops

## Authors
- Smruti Sannabhadti
- Ananya Bammi