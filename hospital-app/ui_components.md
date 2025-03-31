# UI Components for Hospital Santa Joana App

## Color Palette

### Primary Colors
- **Primary Blue**: #1E3A8A
  - Text on primary: #FFFFFF
  - Used for: Primary buttons, headers, important UI elements

- **Secondary Blue**: #3B82F6
  - Text on secondary: #FFFFFF
  - Used for: Secondary actions, links, icons

### Neutral Colors
- **Background**: #F9FAFB
  - Used for: Main application background
  
- **Card Background**: #FFFFFF
  - Used for: Cards, dialogs, popovers

- **Border**: #E5E7EB
  - Used for: Dividers, borders

### Text Colors
- **Primary Text**: #111827
  - Used for: Main content text
  
- **Secondary Text**: #6B7280
  - Used for: Subtitles, descriptions, placeholders

- **Disabled Text**: #9CA3AF
  - Used for: Disabled states

### Status Colors
- **Success**: #10B981
  - Used for: Completed actions, successful operations
  
- **Warning**: #F59E0B
  - Used for: In progress, pending actions
  
- **Error**: #EF4444
  - Used for: Errors, alerts, important notifications

## Typography

### Text Styles
- **Heading 1**
  - Font: SF Pro Display / Roboto
  - Size: 24px
  - Weight: Bold
  - Line height: 32px
  - Used for: Screen titles

- **Heading 2**
  - Font: SF Pro Display / Roboto
  - Size: 20px
  - Weight: Semi-bold
  - Line height: 28px
  - Used for: Section headers

- **Body**
  - Font: SF Pro Text / Roboto
  - Size: 16px
  - Weight: Regular
  - Line height: 24px
  - Used for: Primary content

- **Caption**
  - Font: SF Pro Text / Roboto
  - Size: 14px
  - Weight: Regular
  - Line height: 20px
  - Used for: Secondary information, labels

- **Button Text**
  - Font: SF Pro Text / Roboto
  - Size: 18px
  - Weight: Semi-bold
  - Line height: 24px
  - Used for: All buttons

## Icons

### Navigation Icons
- Home (house icon)
- Catalog (grid icon)
- Cart (cart icon)
- Orders (clipboard icon)
- Invoice (document icon)
- Profile (user icon)

### Action Icons
- Add (plus icon)
- Remove (minus icon)
- Delete (trash icon)
- Edit (pencil icon)
- Search (magnifying glass icon)
- Filter (funnel icon)
- Back (arrow left icon)
- Forward (arrow right icon)
- Close (X icon)
- Menu (hamburger icon)

### Status Icons
- Success (checkmark icon)
- Warning (exclamation mark icon)
- Error (exclamation mark in circle icon)
- Pending (clock icon)
- In Progress (spinning circle icon)
- Delivered (package icon)

## UI Elements

### Buttons

#### Primary Button
- Background: #1E3A8A
- Text: #FFFFFF
- Height: 56px
- Border radius: 12px
- Padding: 16px 24px
- States:
  - Hover: Opacity 0.9
  - Active: Opacity 0.8
  - Disabled: Opacity 0.5

#### Secondary Button
- Background: Transparent
- Text: #1E3A8A
- Border: 1px solid #1E3A8A
- Height: 56px
- Border radius: 12px
- Padding: 16px 24px
- States:
  - Hover: Background #E6EFFF
  - Active: Background #D1E2FF
  - Disabled: Opacity 0.5

#### Icon Button
- Background: Transparent
- Icon color: #1E3A8A
- Size: 44px x 44px
- Border radius: 8px
- States:
  - Hover: Background #F3F4F6
  - Active: Background #E5E7EB
  - Disabled: Opacity 0.5

### Input Fields

#### Text Input
- Background: #FFFFFF
- Border: 1px solid #E5E7EB
- Text color: #111827
- Placeholder color: #9CA3AF
- Height: 56px
- Border radius: 8px
- Padding: 16px
- States:
  - Focus: Border 2px solid #3B82F6
  - Error: Border 2px solid #EF4444
  - Disabled: Background #F3F4F6, Border #E5E7EB

#### Search Input
- Background: #F3F4F6
- Border: none
- Text color: #111827
- Placeholder color: #6B7280
- Height: 48px
- Border radius: 24px
- Padding: 16px
- Search icon on left side
- Clear button on right side (when text is present)

### Cards

#### Product Card
- Background: #FFFFFF
- Border radius: 16px
- Shadow: 0px 4px 6px rgba(0, 0, 0, 0.05)
- Padding: 16px
- Content:
  - Product image (aspect ratio 1:1)
  - Product name (Heading 2)
  - Short description (Body)
  - Price (Heading 2)
  - Add to cart button (Icon Button with plus icon)

#### Order Card
- Background: #FFFFFF
- Border radius: 16px
- Shadow: 0px 4px 6px rgba(0, 0, 0, 0.05)
- Padding: 16px
- Content:
  - Order number and date (Caption)
  - Primary items (Body)
  - Status indicator (pill with appropriate status color)
  - Total amount (Body Bold)
  - Chevron for expanded details (if applicable)

### Navigation

#### Bottom Navigation Bar
- Background: #FFFFFF
- Shadow: 0px -2px 8px rgba(0, 0, 0, 0.05)
- Height: 80px
- Items:
  - Home
  - Catalog
  - Cart (with item count indicator)
  - Orders
  - Invoice
- Active item indicator: Bold icon and text, Primary Blue color

#### Top App Bar
- Background: #FFFFFF
- Shadow: 0px 2px 8px rgba(0, 0, 0, 0.05)
- Height: 64px
- Content:
  - Back button (when applicable)
  - Screen title
  - Action buttons (e.g., search, filter)

### Miscellaneous

#### Badge
- Background: #EF4444 (for notifications/counts)
- Text color: #FFFFFF
- Size: 20px x 20px
- Border radius: 10px
- Font size: 12px
- Font weight: Bold

#### Status Pill
- Height: 24px
- Border radius: 12px
- Padding: 4px 12px
- Font size: 12px
- Font weight: Semi-bold
- Colors:
  - Pending: #F59E0B background, #7C2D12 text
  - In Progress: #3B82F6 background, #FFFFFF text
  - Delivered: #10B981 background, #FFFFFF text
  - Cancelled: #EF4444 background, #FFFFFF text

#### Divider
- Height: 1px
- Color: #E5E7EB
- Margin: 16px 0

#### Loader
- Color: #3B82F6
- Size: 24px
