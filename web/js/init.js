document.addEventListener('DOMContentLoaded', function() {
    var carousel = document.querySelectorAll('.carousel');
    for (var i = 0; i < carousel.length; i++){
        M.Carousel.init(carousel[i], {
            fullWidth: true,
            indicators: true
        });
    }
    var floating = document.querySelectorAll('.fixed-action-btn');
    for (var i = 0; i < floating.length; i++){
        M.FloatingActionButton.init(floating[i]);
    }
    var sidenavs = document.querySelectorAll('.sidenav');
    for (var i = 0; i < sidenavs.length; i++){
        M.Sidenav.init(sidenavs[i]);
    }
    var dropdowns = document.querySelectorAll('.dropdown-trigger');
    for (var i = 0; i < dropdowns.length; i++){
        M.Dropdown.init(dropdowns[i]);
    }
    var collapsibles = document.querySelectorAll('.collapsible');
    for (var i = 0; i < collapsibles.length; i++){
        M.Collapsible.init(collapsibles[i]);
    }
    var featureDiscoveries = document.querySelectorAll('.tap-target');
    for (var i = 0; i < featureDiscoveries.length; i++){
        M.FeatureDiscovery.init(featureDiscoveries[i]);
    }
    var materialboxes = document.querySelectorAll('.materialboxed');
    for (var i = 0; i < materialboxes.length; i++){
        M.Materialbox.init(materialboxes[i]);
    }
    var modals = document.querySelectorAll('.modal');
    for (var i = 0; i < modals.length; i++){
        M.Modal.init(modals[i]);
    }
    var parallax = document.querySelectorAll('.parallax');
    for (var i = 0; i < parallax.length; i++){
        M.Parallax.init(parallax[i]);
    }
    var scrollspies = document.querySelectorAll('.scrollspy');
    for (var i = 0; i < scrollspies.length; i++){
        M.ScrollSpy.init(scrollspies[i]);
    }
    var tabs = document.querySelectorAll('.tabs');
    for (var i = 0; i < tabs.length; i++){
        M.Tabs.init(tabs[i]);
    }
    var tooltips = document.querySelectorAll('.tooltipped');
    for (var i = 0; i < tooltips.length; i++){
        M.Tooltip.init(tooltips[i]);
    }
    var datepicker = document.querySelectorAll('.datepicker');
    for (var i = 0; i < datepicker.length; i++){
        M.Datepicker.init(datepicker[i]);
    }
    var select = document.querySelectorAll('select');
    for (var i = 0; i < select.length; i++){
        M.FormSelect.init(select[i]);
    }
});