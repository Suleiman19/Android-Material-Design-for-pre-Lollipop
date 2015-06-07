# Android-Material-Design-for-pre-Lollipop
Various UI implementations, animations &amp; effects  based on Material Design compatible with pre Lollipop devices as well. (Work in progess)

Implements various Material Design components, that go by the design guidelines. Especially for pre-Lollipop devices.


<b>1) Google+ like screen (Toolbar & FAB animation)</b>
Demonstrates animation similar to the Google+ app. The toolbar and Floating Action Button (FAB) hide upon scrolling down, and translate back up when scrolled up.

Plus the FAB greets users with a grow animation upon entrance.

The Spinner used on the Toolbar, is a custom implementation.

Option to enable fading for the Toolbar on hide and show. Similar to the effect as seen on the Google I/O 2015 app.

<i>NOTE: I've used my own implementation for a FAB (Check myfab.xml)</i>

<b>2) Transparent Toolbar with Ripple imitation</b>
Transparent and overlaid toolbar. On Lollipop devices, Status Bar is transparent as well . The FAB on click, shows a ripple-like effect spread over the entire background. Nothing but a simple circle shape with a grow animation. (Useful for pre-Lollipop).

<b>3) Navigation Drawer</b>
Material Design styled Navigation Drawer with header image and menu. VERY quick way to get started with such a Drawer swiftly. Made using Design Support Library. Since the NavigationView uses a menu resource to load the list of items, if anyone wants to have a custom list with counters for instance, I'd suggest you use a custom library like the MaterialNavigationDrawer from neokree

![alt tag](http://blog.grafixartist.com/wp-content/uploads/2015/05/navigation-drawer-material-design.gif)

<b>4) Toolbar Header Animation</b>
Large header image with on scroll animation for Toolbar. Dynamic Toolbar coloring using Palette class based off the header image. Using the Design Support Library. 

Also includes a Floating Action Button(FAB) Design library widget. See activity_animate_toolbar.xml

![alt tag](http://blog.grafixartist.com/wp-content/uploads/2015/06/toolbar-header-animation.gif)

<b>5) Tab Strip </b>
Material Design Tab strip attached below the Toolbar. Using the Design Support Library, includes on scroll hide and reveal animations.

![alt tag](http://blog.grafixartist.com/wp-content/uploads/2015/06/tabs-defined-e1433590539228.png)



