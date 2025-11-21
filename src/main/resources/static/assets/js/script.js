$(document).ready(function(){
        // Add minus icon for collapse element which is open by default
        $(".collapse.show").each(function(){
        	$(this).prev(".card-header").find(".fas").addClass(" fas fa-angle-down ").removeClass("fas fa-angle-right ");
        });
        
        // Toggle plus minus icon on show hide of collapse element
        $(".collapse").on('show.bs.collapse', function(){
        	$(this).prev(".card-header").find(".fas").removeClass("fas fa-angle-right ").addClass(" fas fa-angle-down ");
        }).on('hide.bs.collapse', function(){
        	$(this).prev(".card-header").find(".fas").removeClass(" fas fa-angle-down").addClass("fas fa-angle-right ");
        });
        
        $('select').selectpicker();
        $('.group-span-filestyle > label').text("Parcourir");
        
    });